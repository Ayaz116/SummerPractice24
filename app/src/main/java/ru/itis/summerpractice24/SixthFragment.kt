package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice24.databinding.FragmentSixthBinding

class SixthFragment : Fragment(R.layout.fragment_sixth) {
    private var binding: FragmentSixthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSixthBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}


