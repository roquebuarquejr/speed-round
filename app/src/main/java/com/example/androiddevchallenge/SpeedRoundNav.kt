/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.DASHBOARD
import com.example.androiddevchallenge.MainDestinations.LOGIN
import com.example.androiddevchallenge.MainDestinations.ONBOARD
import com.example.androiddevchallenge.ui.screens.DashboardScreen
import com.example.androiddevchallenge.ui.screens.LoginScreen
import com.example.androiddevchallenge.ui.screens.OnboardScreen

object MainDestinations {
    const val ONBOARD = "onboard"
    const val LOGIN = "login"
    const val DASHBOARD = "dashboard"
}

@Composable
fun NavGraph(startDestination: String = ONBOARD) {

    val navController = rememberNavController()
    NavHost(navController, startDestination = startDestination) {
        composable(route = ONBOARD) {
            OnboardScreen {
                navController.navigate(LOGIN)
            }
        }
        composable(route = LOGIN) {
            LoginScreen {
                navController.navigate(DASHBOARD)
            }
        }
        composable(route = DASHBOARD) {
            DashboardScreen()
        }
    }
}
