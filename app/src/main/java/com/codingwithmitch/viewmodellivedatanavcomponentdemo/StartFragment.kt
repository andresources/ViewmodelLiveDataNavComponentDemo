package com.codingwithmitch.viewmodellivedatanavcomponentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.viewmodellivedatanavcomponentdemo.databinding.FragmentStartBinding
import com.codingwithmitch.viewmodellivedatanavcomponentdemo.viewmodel.OrderViewModel

class StartFragment : Fragment() {
    // Binding object instance corresponding to the fragment_start.xml layout
    private var binding: FragmentStartBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_start, container, false)
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding =  fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }

    fun orderCupcake(quantity: Int) {
        // Update the view model with the quantity
        sharedViewModel.setQuantity(quantity)

        // If no flavor is set in the view model yet, select red_velvet as default flavor
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.red_velvet))
        }

        // Navigate to the next destination to select the flavor of the cupcakes
        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
    }


}