package com.rayya.aplikasimobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var tab1: Button? = null
    private var tab2: Button? = null
    private var tab3: Button? = null
    private var homeTab: LinearLayout? = null
    private var profileTab: LinearLayout? = null
    private var settingsTab: LinearLayout? = null
    private var lifecycleStatus: TextView? = null
    private var createCount = 0
    private var startCount = 0
    private var resumeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // ✅ pakai layout kamu sendiri

        Log.d(TAG, "onCreate() dipanggil")
        createCount++

        // Initialize views
        initializeViews()

        // Set initial active tab
        setActiveTab(tab1!!, homeTab!!)

        // Update lifecycle status
        updateLifecycleStatus("onCreate")

        // Restore state if available
        if (savedInstanceState != null) {
            createCount = savedInstanceState.getInt("createCount", createCount)
            startCount = savedInstanceState.getInt("startCount", startCount)
            resumeCount = savedInstanceState.getInt("resumeCount", resumeCount)
            val selectedTab = savedInstanceState.getInt("selectedTab", 0)
            selectTab(selectedTab)
        }
    }

    private fun initializeViews() {
        tab1 = findViewById(R.id.tab1)
        tab2 = findViewById(R.id.tab2)
        tab3 = findViewById(R.id.tab3)

        homeTab = findViewById(R.id.home_tab)
        profileTab = findViewById(R.id.profile_tab)
        settingsTab = findViewById(R.id.settings_tab)

        lifecycleStatus = findViewById(R.id.lifecycle_status)

        tab1?.setOnClickListener { setActiveTab(tab1!!, homeTab!!) }
        tab2?.setOnClickListener { setActiveTab(tab2!!, profileTab!!) }
        tab3?.setOnClickListener { setActiveTab(tab3!!, settingsTab!!) }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() dipanggil")
        startCount++
        updateLifecycleStatus("onStart")
        Toast.makeText(this, "Aktivitas dimulai", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() dipanggil")
        resumeCount++
        updateLifecycleStatus("onResume")
        Toast.makeText(this, "Aktivitas aktif", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() dipanggil")
        updateLifecycleStatus("onPause")
        Toast.makeText(this, "Aktivitas dijeda", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() dipanggil")
        updateLifecycleStatus("onStop")
        Toast.makeText(this, "Aktivitas dihentikan", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() dipanggil")
        updateLifecycleStatus("onDestroy")
        Toast.makeText(this, "Aktivitas dihancurkan", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() dipanggil")
        updateLifecycleStatus("onRestart")
        Toast.makeText(this, "Aktivitas dimulai ulang", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState() dipanggil")

        outState.putInt("createCount", createCount)
        outState.putInt("startCount", startCount)
        outState.putInt("resumeCount", resumeCount)
        outState.putInt("selectedTab", this.selectedTabIndex)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState() dipanggil")
        updateLifecycleStatus("onRestoreInstanceState")
    }

    private fun setActiveTab(activeButton: Button, activeTab: LinearLayout) {
        resetAllTabs()

        activeButton.setTextColor(getColor(android.R.color.white))
        activeButton.backgroundTintList =
            ContextCompat.getColorStateList(this, android.R.color.holo_blue_dark)

        homeTab?.visibility = View.GONE
        profileTab?.visibility = View.GONE
        settingsTab?.visibility = View.GONE
        activeTab.visibility = View.VISIBLE
    }

    private fun resetAllTabs() {
        val defaultColor = getColor(android.R.color.black)
        val defaultBackground = android.R.color.white

        tab1?.setTextColor(defaultColor)
        tab2?.setTextColor(defaultColor)
        tab3?.setTextColor(defaultColor)

        tab1?.backgroundTintList = ContextCompat.getColorStateList(this, defaultBackground)
        tab2?.backgroundTintList = ContextCompat.getColorStateList(this, defaultBackground)
        tab3?.backgroundTintList = ContextCompat.getColorStateList(this, defaultBackground)
    }

    private val selectedTabIndex: Int
        get() {
            return when {
                homeTab?.visibility == View.VISIBLE -> 0
                profileTab?.visibility == View.VISIBLE -> 1
                else -> 2
            }
        }

    private fun selectTab(index: Int) {
        when (index) {
            0 -> setActiveTab(tab1!!, homeTab!!)
            1 -> setActiveTab(tab2!!, profileTab!!)
            2 -> setActiveTab(tab3!!, settingsTab!!)
        }
    }

    private fun updateLifecycleStatus(currentMethod: String?) {
        val status = """
            Status Lifecycle:
            onCreate: $createCount x
            onStart: $startCount x
            onResume: $resumeCount x
            Method terakhir: $currentMethod
        """.trimIndent()

        lifecycleStatus?.text = status
    }

    fun onHomeButtonClick(view: View?) {
        Toast.makeText(this, "Home button clicked!", Toast.LENGTH_SHORT).show()
    }

    fun onSimulateRotationClick(view: View?) {
        recreate()
    }

    fun openRelativeLayout(view: View?) {
        val intent = Intent(this, RelativeLayoutActivity::class.java)
        startActivity(intent)
    }

    fun openConstraintLayout(view: View?) {
        val intent = Intent(this, ConstraintLayoutActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private const val TAG = "LifecycleDemo"
    }
}
