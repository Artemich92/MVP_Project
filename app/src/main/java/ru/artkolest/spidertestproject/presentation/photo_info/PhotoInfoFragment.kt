package ru.artkolest.spidertestproject.presentation.photo_info

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_photo_info.*
import kotlinx.android.synthetic.main.fragment_photo_info.gLoad
import kotlinx.android.synthetic.main.item_photo.view.*
import ru.artkolest.spidertestproject.App
import ru.artkolest.spidertestproject.R
import ru.artkolest.spidertestproject.base.BaseFragment
import ru.artkolest.spidertestproject.base.extensions.hide
import ru.artkolest.spidertestproject.base.extensions.onClick
import ru.artkolest.spidertestproject.base.extensions.show
import ru.artkolest.spidertestproject.databinding.FragmentPhotoInfoBinding
import ru.artkolest.spidertestproject.domain.models.comments.Comments

class PhotoInfoFragment : BaseFragment<PhotoInfoContract.Presenter>(
    R.layout.fragment_photo_info), PhotoInfoContract.View {

    private val binding by viewBinding(FragmentPhotoInfoBinding::bind)
    private lateinit var navController: NavController
    private lateinit var adapter: CommentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        navController = view.findNavController()
        initUi()
        initRecyclerView()
        requireActivity().onBackPressedDispatcher.addCallback(this@PhotoInfoFragment) {
            navController.navigate(R.id.action_photoInfoFragment_to_photosFragment)
        }

    }

    private fun initUi() = with(binding) {
        requireArguments().getString(IMAGE_AUTHOR)
            ?.let { toolbar.tvTitle.text = getString(R.string.author, it) }
        toolbar.ivClose.onClick {
            navController.navigate(R.id.action_photoInfoFragment_to_photosFragment)

        }

        Glide.with(requireContext())
            .asBitmap()
            .load(requireArguments().getString(IMAGE_LINK))
            .placeholder(R.drawable.hourglass)
            .into(sivPhoto)
        presenter.loadImageInfo(requireArguments().getString(DATA_ID).toString())
    }

    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity)
        rvComments.layoutManager = linearLayoutManager
        adapter = CommentAdapter()
        rvComments.setHasFixedSize(true)
        rvComments.adapter = adapter
    }

    override fun onSetData(comments: List<Comments>) {
        adapter.setComment(comments)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(requireContext(), throwable.message.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onShowErrorToast() {
        Toast.makeText(requireContext(),
            "Ошибка загрузки комментариев, postId равен нулю",
            Toast.LENGTH_LONG).show()
    }

    override fun onShowLoad() = gLoad.show()

    override fun onHideLoad() = gLoad.hide()

    override fun onDestroyView() {
        presenter.dispose()
        super.onDestroyView()
    }

    override fun createComponent() = App.instance.getAppComponent()
        .createPhotoInfoFragment().inject(this)

    companion object {
        private const val IMAGE_LINK = "imageLink"
        private const val IMAGE_AUTHOR = "imageAuthor"
        private const val DATA_ID = "data_id"
    }

}