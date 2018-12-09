package by.gomel.marseille.main.presentation

import android.os.Bundle
import androidx.navigation.Navigation
import by.gomel.marseille.R
import by.gomel.marseille.base.view.BaseActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_app_bar.setNavigationOnClickListener {
            //MainMenuDialogFragment().show(supportFragmentManager, MainMenuDialogFragment::javaClass.name)
        }
    }

    override fun onSupportNavigateUp() = router().navigateUp()
    override fun router() = Navigation.findNavController(this, R.id.song_nav_host_fragment)

    fun bottomBar(): BottomAppBar = bottom_app_bar
    fun bottomBarButton(): FloatingActionButton = bottom_app_bar_button
}