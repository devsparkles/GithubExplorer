package com.devsparkle.githubexplorer.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devsparkle.githubexplorer.R
import com.devsparkle.githubexplorer.domain.model.CommitDTO

class ListAdapter(private val context: Context, private val list: MutableList<CommitDTO>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val commit = list[position]
        holder.bind(commit)

        holder.layout!!.setOnClickListener {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.commit_item_layout, parent, false)
        return ListViewHolder(
            itemView
        )
    }

    fun removeAt(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }

    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var layout = itemView.findViewById<ConstraintLayout>(R.id.line)
        val title = itemView.findViewById<TextView>(R.id.textViewCommitTitle)
        val date = itemView.findViewById<TextView>(R.id.textViewCommitDate)
        val authorImage = itemView.findViewById<ImageView>(R.id.imageViewAuthorImage)

        fun bind(item: CommitDTO) {
            title.setText(item.title)
            date.setText(item.timeAndDate)

            Glide.with(itemView.context)
                .load(item.authorImage)
                .apply(RequestOptions.circleCropTransform())
                .into(authorImage)
        }
    }

    interface onItemClickListener {
        fun itemRemoveClick(post: CommitDTO)
        fun itemDetail(postId : String)
    }
}