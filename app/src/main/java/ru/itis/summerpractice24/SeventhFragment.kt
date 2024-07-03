package ru.itis.summerpractice24

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summerpractice24.databinding.FragmentSeventhBinding

class SeventhFragment : Fragment(R.layout.fragment_seventh) {
    private var binding: FragmentSeventhBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSeventhBinding.bind(view)

        val id = arguments?.getString("ARG")?:"ERROR"
        val music = MusicRepository.musics.find { it.id == id.toInt()}


        binding?.run {
            tvDetailName.text = music?.name
            tvDetailAutor.text = music?.autor
            tvDetailAlbum.text = "Альбом:" + music?.album
            tvDetailTText.text = music?.text
            tvTextText.text = "Текст песни"


            Glide.with(requireContext())
                .load(music?.imgURL)
                .into(ivDetailImage)
            ivBackImage.setImageResource(R.drawable.arrow_back_24px)
            ivBackImage.setOnClickListener{
                findNavController().navigate(R.id.action_seventhFragment_to_thirdFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}