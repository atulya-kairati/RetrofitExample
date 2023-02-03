package com.atulya.retrofitexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.atulya.retrofitexample.databinding.ListItemBinding
import com.atulya.retrofitexample.network.Person

class Adapter(private val list: List<Person>) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val person = list[position]

        holder.bind(person)
    }

    override fun getItemCount() = list.size
}

class Holder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(person: Person) {
        binding.characterName.text = person.name
        binding.characterImage.load(person.image) {
            transformations(CircleCropTransformation())
        }
    }
}