package com.amitapps.sbnriapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.amitapps.sbnriapp.R
import com.amitapps.sbnriapp.data.network.DataModel
import com.bumptech.glide.Glide

// adapter for vertical
class MovieAdapter(private val movieList: List<DataModel>) :
    RecyclerView.Adapter<MovieAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = movieList[position]
        holder.bind(product)
    }



    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productImageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(movie: DataModel) {
//            Log.d("productAdapter_abc_adapter", product.product_name)

            // Load image using Glide library, or you can use any other image loading library
            Glide.with(itemView)
                .load(movie.image_url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(productImageView)
        }
    }
}