package ru.itis.summerpractice24

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import ru.itis.summerpractice24.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    private var viewBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding!!.root)
        initViews()

    }

    private fun initViews() {
        viewBinding?.apply {
            editTextNumber.doOnTextChanged { text, _, _, _ ->
                text?.let {
                    btn.isEnabled = text.isNotEmpty() && text.toString().toIntOrNull() != null
                }
            }

            btn.setOnClickListener {
                val count = editTextNumber.text.toString().toInt()
                editTextNumber.text = null
                btn.isEnabled = false
                val guns = generateGuns(count)
                val winner = conductRound(guns)
                Log.i("Конец соревнований", "Победитель: ${winner.name} с силой ${winner.power}")
            }
        }
    }

    private fun getRandomGun(): Gun {
        val namesOfSniperGun = listOf("Barrett M82", "Dragunov SVD", "Remington 700", "Accuracy International AWM", "CheyTac M200 Intervention", "M24 Sniper Weapon System", "Steyr SSG 69", "H&K PSG1", "L96A1", "Knight's Armament M110", "McMillan TAC-50", "Barrett MRAD", "Zastava M93 Black Arrow", "Tikka T3x TAC A1", "Ruger Precision Rifle", "Sako TRG-42", "Savage 110 BA Stealth", "FN Ballista", "DSR-Precision DSR 50", "Blaser R93 Tactical")
        val namesOfAutomaticGun = listOf("AK-47", "M16", "FN SCAR", "H&K G36", "Steyr AUG", "Tavor TAR-21", "FAMAS", "CZ Bren 2", "Galil ACE", "AK-74", "M4 Carbine", "SIG SG 550", "H&K HK416", "FN F2000", "Beretta ARX160", "Bushmaster ACR", "L85A2", "Type 95 (QBZ-95)", "AK-12", "IMI Galil")
        val namesOfPistol = listOf("Glock 17", "Colt M1911", "Beretta 92FS", "Sig Sauer P226", "Walther P99", "Smith & Wesson M&P", "CZ 75", "H&K USP", "Ruger SR9", "FN Five-seveN", "Springfield XD", "Taurus PT92", "Steyr M9", "Desert Eagle", "Browning Hi-Power", "Kahr K9", "Beretta PX4 Storm", "Sig Sauer P320", "Walther PPK", "Beretta APX")
        val namesOfShotgun = listOf("Remington 870", "Mossberg 500", "Benelli M4", "SPAS-12", "Ithaca 37", "Winchester 1300", "Saiga-12", "Franchi SPAS-15", "Kel-Tec KSG", "FN SLP", "Benelli Supernova", "Beretta 1301", "H&K FABARM FP6", "Maverick 88", "Stoeger M3000", "Browning BPS", "DP-12", "Charles Daly 601", "Hatsan Escort", "Weatherby PA-08")
        val year = Random.nextInt(1000, 2024)
        val weight = Random.nextInt(100, 50000)
        val power = Random.nextInt(1, 100)

        return when (Random.nextInt(4)) {
            0 -> SniperGun(namesOfSniperGun.random(), year, weight, power, Random.nextInt(100, 1000), Random.nextInt(1, 100))
            1 -> AutomaticGun(namesOfAutomaticGun.random(), year, weight, power, Random.nextInt(100, 1000), Random.nextInt(1, 100))
            2 -> Pistol(namesOfPistol.random(), year, weight, power, Random.nextInt(1, 20), Random.nextInt(1, 100))
            3 -> Shotgun(namesOfShotgun.random(), year, weight, power, Random.nextInt(1, 10), Random.nextInt(1, 20))
            else -> throw IllegalArgumentException("Ошибка")
        }
    }

    private fun generateGuns(count: Int): List<Gun>{
        return List(count) { getRandomGun() }
        }

    private fun conductRound(guns: List<Gun>): Gun {
        var remainingGuns = guns.toMutableList()

        while (remainingGuns.size > 1) {
            val nextRound = mutableListOf<Gun>()

            for (i in remainingGuns.indices step 2) {
                if (i + 1 < remainingGuns.size) {
                    val gun1 = remainingGuns[i]
                    val gun2 = remainingGuns[i + 1]
                    val winner = race(gun1, gun2)
                    Log.i("Соревнование","--- Раунд между ${gun1.name} и ${gun2.name}, Победитель ${winner.name}")
                    nextRound.add(winner)
                } else {
                    val gun = remainingGuns[i]
                    Log.i("Соревнование","--- ${gun.name} - Нет пары, следующий круг")
                    nextRound.add(gun)
                }
            }
            remainingGuns = nextRound
        }

        return remainingGuns.first()
    }

    private fun race(gun1: Gun, gun2: Gun): Gun {
        return when {
            gun1.power > gun2.power -> gun1
            gun1.power < gun2.power -> gun2
            else -> if (Random.nextBoolean()) gun1 else gun2
        }
    }

}