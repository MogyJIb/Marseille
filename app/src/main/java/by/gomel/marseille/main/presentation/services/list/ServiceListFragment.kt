package by.gomel.marseille.main.presentation.services.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import by.gomel.marseille.R
import by.gomel.marseille.base.view.BaseFragment
import by.gomel.marseille.main.data.models.Service
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.ext.android.inject


class ServiceListFragment : BaseFragment(), ServiceListContract.View {
    override fun updateServices(service: List<Service>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val presenter: ServiceListContract.Presenter by inject()

//    private lateinit var songsAdapter: SongsAdapter
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View?
//            = inflater.inflate(R.layout.fragment_songlist, container, false)
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        /* Init bottom app bar with button */
//        bottomBarButton().run {
//            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
//                override fun onHidden(fab: FloatingActionButton?) {
//                    bottomBar().replaceMenu(R.menu.songlist_bottom_menu)
//                    bottomBar().fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
//
//                    setImageResource(R.drawable.outline_add_white_24)
//                    setOnClickListener { presenter.onAddSongClicked() }
//
//                    show()
//                }
//            })
//        }
//
//        /* Init adapter and set up recycler view */
//        songsAdapter = SongsAdapter()
//        songsAdapter.onClickListener = presenter::onSongItemClicked
//
//        songs_recycler_view.apply {
//            adapter = songsAdapter
//
//            val dividerItemDecoration = DividerItemDecoration(
//                    context, DividerItemDecoration.VERTICAL)
//            ContextCompat.getDrawable(context(), R.drawable.list_divider)?.let {
//                dividerItemDecoration.setDrawable(it)
//            }
//            addItemDecoration(dividerItemDecoration)
//        }
//    }
//
//    override fun updateSongs(songs: List<Song>) = songsAdapter.updateItems(songs)
}