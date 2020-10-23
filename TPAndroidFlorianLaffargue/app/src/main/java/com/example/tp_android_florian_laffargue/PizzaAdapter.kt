package com.example.tp_android_florian_laffargue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_and_version.*
import kotlinx.android.synthetic.main.item_and_version.view.*

class PizzaAdapter(val items: Array<Pizza>) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>()
{
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
            return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
        }

        return ViewHolder(parent.inflate(R.layout.item_and_version))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindAndVersion(items[position])
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), LayoutContainer {

        override val containerView: View?
        get() = itemView

        fun bindAndVersion(andVersion: Pizza) {
            with(andVersion) {
                itemView.pizzaTxt.text = andVersion.name
                itemView.pizzaImg.setImageResource(andVersion.img)
                itemView.pizzaIngredients.text = andVersion.ingredients

                pizzaImg.setOnClickListener {
                    //itemView.context.toast("$name")
                    Toast.makeText(itemView.context, "$name", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }


}