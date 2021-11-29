package mx.konfio.dogslover.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.konfio.dogslover.R
import mx.konfio.dogslover.db.entities.DogsEntity

class DogsRecyclerAdapter(
    private val dogList: MutableList<DogsEntity>,
    private val mActivity: Activity
) : RecyclerView.Adapter<DogsRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DogsRecyclerViewHolder = DogsRecyclerViewHolder(
        LayoutInflater
            .from(parent.context).inflate(R.layout.item_dog, parent, false)
    )

    override fun onBindViewHolder(holder: DogsRecyclerViewHolder, position: Int) {
        val dogItem = dogList[position]
        holder.tvYear.text =
            java.lang.String.format(mActivity.getString(R.string.text_dog_year), dogItem.age)
        holder.tvNameDog.text = dogItem.dogName
        holder.tvDescription.text = dogItem.description
        Glide
            .with(mActivity)
            .load(dogItem.url)
            .into(holder.ivDog)
    }

    override fun getItemCount(): Int = dogList.size

}

class DogsRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvNameDog: TextView = itemView.findViewById(R.id.tvNameDog)
    val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    val tvYear: TextView = itemView.findViewById(R.id.tvYear)
    val ivDog: ImageView = itemView.findViewById(R.id.ivDog)
}