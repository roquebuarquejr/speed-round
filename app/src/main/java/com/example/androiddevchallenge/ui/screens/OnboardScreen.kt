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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.MySootheBackground
import com.example.androiddevchallenge.components.MySootheButton
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun OnboardScreen(onLoginButtonClick: () -> Unit) {
    MySootheBackground(R.drawable.ic_bg_welcome) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painterResource(id = R.drawable.ic_logo), "Logo image")
            Spacer(Modifier.size(32.dp))
            MySootheButton(
                text = "Sign up",
                backgroundColor = colors.primary,
                contentColor = colors.onPrimary,
                onClick = { }
            )
            Spacer(Modifier.size(8.dp))
            MySootheButton(
                text = "Log in",
                backgroundColor = colors.secondary,
                contentColor = colors.onSecondary,
                onClick = onLoginButtonClick
            )
        }
    }
}

@Preview
@Composable
fun OnboardScreenPreview() {
    MyTheme {
        OnboardScreen(onLoginButtonClick = {})
    }
}
