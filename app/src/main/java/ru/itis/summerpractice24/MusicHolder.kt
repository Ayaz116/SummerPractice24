package ru.itis.summerpractice24

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import ru.itis.summerpractice24.databinding.ItemMusicBinding

class MusicHolder(
    private val binding: ItemMusicBinding,
    private val onClick: (Music) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(music: Music){
        binding.run {
            tvMusic.text = music.name
            tvMusicAutor.text = music.autor

            val radius = 12

            Glide.with(itemView.context)
                .load(music.imgURL)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(radius)))
                .into(ivImage)

            root.setOnClickListener {
                onClick(music)
            }

        }
    }
}