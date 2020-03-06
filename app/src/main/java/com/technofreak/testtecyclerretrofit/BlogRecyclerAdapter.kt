package com.technofreak.testtecyclerretrofit


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.technofreak.testtecyclerretrofit.models.BLog

import kotlinx.android.synthetic.main.layout_blog_list_item.view.*
import kotlin.collections.ArrayList


class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private val TAG: String = "AppDebug"

    private var items: List<BLog> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }


    class BlogItemDiffCallback(
        var oldBlogList: List<BLog>,
        var newBlogList: List<BLog>
    ):DiffUtil.Callback(){
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldBlogList.get(oldItemPosition).title == newBlogList.get(newItemPosition).title
        }

        override fun getOldListSize(): Int =oldBlogList.size

        override fun getNewListSize(): Int = newBlogList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            return oldBlogList.get(oldItemPosition).equals(newBlogList.get(newItemPosition))
        }

    }



    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BLog>){

        val oldList=items
        val diffResult : DiffUtil.DiffResult=DiffUtil.calculateDiff(
            BlogItemDiffCallback(
                oldList,blogList
            )
        )
        items = blogList
        diffResult.dispatchUpdatesTo(this)



    }

    class BlogViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val blog_image = itemView.blog_image
        val blog_title = itemView.blog_title
        val blog_author = itemView.blog_author

        fun bind(blogPost: BLog){

            blog_image.setText(blogPost.body)
            blog_title.setText(blogPost.title)
            blog_author.setText(blogPost.id)

        }

    }

}
