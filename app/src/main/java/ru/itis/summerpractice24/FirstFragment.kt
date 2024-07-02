package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice24.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var binding: FragmentFirstBinding ? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)



        binding?.run {
            button.setOnClickListener {
                val text = editText.text?.toString()
                val bundle = Bundle()
                bundle.putString("ARG", text)

                if (text?.isNotEmpty() == true) {
                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment, args = bundle)
                } else {
                    Snackbar.make(
                        view,
                        "Для отправки текста требуется заполнить поле",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }   override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}