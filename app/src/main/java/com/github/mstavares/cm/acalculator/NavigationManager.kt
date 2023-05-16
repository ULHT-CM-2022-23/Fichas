package com.github.mstavares.cm.acalculator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object NavigationManager {

    private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
        val transition = fm.beginTransaction()
        transition.replace(R.id.frame, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }

    fun goToCalculatorFragment(fm: FragmentManager) {
        placeFragment(fm, CalculatorFragment())
    }

    fun goToHistoryFragment(fm: FragmentManager) {
        placeFragment(fm, HistoryFragment())
    }

    fun goToOperationDetailFragment(fm: FragmentManager, uuid: String) {
        placeFragment(fm, OperationDetailFragment.newInstance(uuid))
    }

    fun goToMapFragment(fm: FragmentManager) {
        placeFragment(fm, MapFragment())
    }

}
