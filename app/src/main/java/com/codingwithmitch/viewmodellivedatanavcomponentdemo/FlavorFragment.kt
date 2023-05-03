package com.codingwithmitch.viewmodellivedatanavcomponentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.codingwithmitch.viewmodellivedatanavcomponentdemo.databinding.FragmentFlavorBinding
import com.codingwithmitch.viewmodellivedatanavcomponentdemo.viewmodel.OrderViewModel


class FlavorFragment : Fragment() {
    private var binding: FragmentFlavorBinding? = null
    // Binding object instance corresponding to the fragment_flavor.xml layout
    private val sharedViewModel: OrderViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentFlavorBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            flavorFragment = this@FlavorFragment
            viewModel = sharedViewModel
            // Specify the fragment as the lifecycle owner
            lifecycleOwner = viewLifecycleOwner
        }
    }
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}