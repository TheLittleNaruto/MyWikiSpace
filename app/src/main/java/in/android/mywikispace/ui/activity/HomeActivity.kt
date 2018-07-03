package `in`.android.mywikispace.ui.activity

import `in`.android.mywikispace.R
import `in`.android.mywikispace.ui.fragment.HomeFragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*
import `in`.android.mywikispace.utils.AppConstants.Companion.TAG_HOME_FRAGMENT

class HomeActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        startFragment(HomeFragment.newInstance(), TAG_HOME_FRAGMENT)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_share -> {

            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun startFragment(fragment: Fragment, tag: String) {

        val transaction = supportFragmentManager
                .beginTransaction()
        transaction
                .replace(R.id.container, fragment, tag)
                if(!tag.equals(TAG_HOME_FRAGMENT)) transaction.addToBackStack(null)
                transaction.commit()
    }

    fun goBack() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        }
        // if extras != null then we have to go back to the application which launched this activity
        if (intent.extras != null) {
            moveTaskToBack(true)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
