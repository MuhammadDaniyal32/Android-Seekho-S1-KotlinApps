/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.databinding.ActivityGridListBinding.inflate
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    /*protected lateinit var dataset: List<Dog>*/
    //private var dataset: List<Dog> = ArrayList()
    val dataset: List<Dog> = DataSource.dogs
    /**
     * Initialize view elements
     */
    class DogCardViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val dog_name_tv:TextView = view.findViewById(R.id.dog_name)
        val dog_age_tv:TextView = view.findViewById(R.id.dog_age)
        val dog_hobbies_tv:TextView = view.findViewById(R.id.dog_hobbies)
        val imageView: ImageView = view.findViewById(R.id.img_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.

        // TODO Inflate the layout
        if(layout==Layout.GRID)
        {
             val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_list_item, parent, false)
             return DogCardViewHolder(view)
        }
        else {
            val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_horizontal_list_item, parent, false)
            return DogCardViewHolder(view)
        }

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.

    }

    override fun getItemCount():Int
    {
     return dataset.size
    }
    // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val item = dataset[position]
        // TODO: Set the image resource for the current dog

        holder.imageView.setImageResource(item.imageResourceId)
        holder.dog_age_tv.setText(item.age);
        holder.dog_name_tv.setText(item.name);

        // TODO: Set the text for the current dog's name
        // TODO: Set the text for the current dog's age
        val resources = context?.resources
        holder.dog_hobbies_tv.text = resources?.getString(R.string.dog_hobbies,item.hobbies)

        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
