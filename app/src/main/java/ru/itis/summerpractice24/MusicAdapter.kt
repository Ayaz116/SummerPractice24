package ru.itis.summerpractice24

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.summerpractice24.databinding.ItemMusicBinding

class MusicAdapter(
    private val list: List<Music>,
    private val onClick: (Music) -> Unit,
) : RecyclerView.Adapter<MusicHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicHolder = MusicHolder(
        ItemMusicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false),
        onClick = onClick

    )

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}