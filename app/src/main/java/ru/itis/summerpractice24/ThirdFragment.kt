package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice24.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var binding: FragmentThirdBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentThirdBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}