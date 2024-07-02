package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice24.databinding.FragmentFifthBinding

class FifthFragment : Fragment(R.layout.fragment_fifth) {
    private var binding: FragmentFifthBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFifthBinding.bind(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}