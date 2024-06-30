package ru.itis.summerpractice24

import android.util.Log

open class Gun(
    open val name: String,
    open val year: Int,
    open val weight: Int,
    open val power: Int
) {
        open fun getInfo() {
            Log.i(
                "Gun Info",
                "Name: $name \nYear of release: $year\nWeight: $weight\nPower: $power"
            )
    }
}

class SniperGun(
    override val name: String,
    override val year: Int,
    override val weight: Int,
    override val power: Int,
    val RangeOfFire: Int,
    val Stability: Int
): Gun(name,year,weight,power){

    override fun getInfo() {
        Log.i(
            "Button Clicked",
            "Name: $name \nYear of release: $year\nWeight: $weight\nPower: $power\nRangeOfFire:" +
                    " $RangeOfFire\nStability: $Stability"
        )
    }
}

class AutomaticGun(
    override val name: String,
    override val year: Int,
    override val weight: Int,
    override val power: Int,
    val rateOfFire: Int,
    val accuracy : Int
): Gun(name,year,weight,power){

    override fun getInfo() {
        Log.i(
            "Button Clicked",
            "Name: $name \nYear of release: $year\nWeight: $weight\nPower: $power\nRate Of Fire:" +
                    " $rateOfFire\nAccuracy: $accuracy"
        )
    }
}

class Pistol(
    override val name: String,
    override val year: Int,
    override val weight: Int,
    override val power: Int,
    val magazineCapacity : Int,
    val RechargeRate: Int
): Gun(name,year,weight,power){

    override fun getInfo() {
        Log.i(
            "Button Clicked",
            "Name: $name \nYear of release: $year\nWeight: $weight\nPower: $power\nCapacity of magazine:" +
                    " $magazineCapacity\nRecharge Rate: $RechargeRate"
        )
    }
}


class Shotgun(
    override val name: String,
    override val year: Int,
    override val weight: Int,
    override val power: Int,
    val magazineCapacity : Int,
    val ShotSize : Int,
): Gun(name,year,weight,power){

    override fun getInfo() {
        Log.i(
            "Button Clicked",
            "Name: $name \nYear of release: $year\nWeight: $weight\nPower: $power\nCapacity of magazine:" +
                    " $magazineCapacity\nShot Size: $ShotSize"
        )
    }
}
