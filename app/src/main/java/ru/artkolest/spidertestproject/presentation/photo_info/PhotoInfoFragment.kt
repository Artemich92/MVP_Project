package ru.artkolest.spidertestproject.presentation.photo_info

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kotlinx.android.synthetic.main.fragment_photo_info.*
import ru.artkolest.spidertestproject.App
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.BaseFragment
import ru.artkolest.spidertestproject.databinding.FragmentPhotoInfoBinding
import ru.artkolest.spidertestproject.databinding.FragmentPhotosBinding

class PhotoInfoFragment: BaseFragment<PhotoInfoContract.Presenter>(
    R.layout.fragment_photo_info), PhotoInfoContract.View {

    private val binding by viewBinding(FragmentPhotoInfoBinding::bind)
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        navController = view.findNavController()
        onInitUi()


    }

    private fun onInitUi() = with(binding) {

        btn_photos.setOnClickListener{
            navController.navigate(R.id.action_photoInfoFragment_to_photosFragment)
        }
    }

    override fun createComponent() = App.instance.getAppComponent()
        .createPhotoInfoFragment().inject(this)
}