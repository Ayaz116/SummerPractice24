package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.itis.summerpractice24.databinding.FragmentThirdBinding

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private var binding: FragmentThirdBinding? = null

    private var adapter: MusicAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentThirdBinding.bind(view)


        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter(){
        adapter = MusicAdapter(
            list = MusicRepository.musics,
            onClick = {
                val bundle = Bundle()
                binding?.run { bundle.putString("ARG", it.id.toString())
                    findNavController().navigate(R.id.action_thirdFragment_to_seventhFragment, args = bundle) }

            })


        binding?.run {
            rvMusic.adapter = adapter
            rvMusic.layoutManager = LinearLayoutManager(requireContext())
        }
    }


}