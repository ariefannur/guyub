package com.github.arief.annuur.guyub.utils

import com.github.arief.annuur.guyub.model.BottomNavField
import com.github.arief.annuur.guyub.model.FormField
import com.github.arief.annuur.guyub.model.ItemBasic
import com.github.arief.annuur.guyub.model.ItemFeed
import com.github.arief.annuur.guyub.model.LabelType
import com.github.arief.annuur.guyub.model.LayoutField
import com.github.arief.annuur.guyub.model.PasswordType
import com.github.arief.annuur.guyub.model.TextFieldType
import com.github.arief.annuur.guyub.model.UIField
import com.github.arief.annuur.guyub.model.UIFieldType
import com.github.arief.annuur.guyub.model.UserField

object FakeData {

    val singleFormData = listOf(
        FormField.TextField(
            "Input Number",
            TextFieldType.NUMBER,
            "input_number",
            true
        ),
        FormField.TextField(
            "Input Nominal",
            TextFieldType.NOMINAL,
            "input_nominal",
            true
        ),
        FormField.TextField(
            "Input Text",
            TextFieldType.TEXT,
            "input_text",
            true
        ),
        FormField.TextFieldOption(label = "Option", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
        ), key = "option_1"),
        FormField.DatePicker(
            "Input Tanggal",
            "date"
        ),
        FormField.RadioButton(label = "Select option below", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
        ), key = "radio_1"),
        FormField.RadioButton(label = "Pilih salah satu", options = listOf(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4",
            "Option 5",
            "Option 6",
            "Option 7",
        ), key = "radio_2"),

        FormField.Button(label = "Submit", key = "btn", required = true, enable = false)
    )

    val sampleAuthForm = listOf(
        FormField.PhoneNumber("Phone Number", "phone_number", true),
        FormField.Email("Email", "email", true).apply {
           message = "Wrong email format"
        },
        FormField.Password("Password", "password", required = true),
        FormField.Password("Retype Password", "password", type = PasswordType.CHECK_PASSWORD,required = true)
    )


    val sampleFeed = UIField.Feed(
        UIFieldType.GRID,
        listOf(
            ItemFeed(
                image = "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f",
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Nature with beatiful "
            ),
                ItemFeed(
                image = "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f",
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Nature with beatiful "
            ),
                ItemFeed(
                image = "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f",
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Nature with beatiful "
            ),
                ItemFeed(
                image = "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f",
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Nature with beatiful "
            ),
                ItemFeed(
                image = "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f",
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Nature with beatiful "
            ),
                ItemFeed(
                image = "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d",
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Beautiful leaf drop "
            ),
                ItemFeed(
                image = "https://images.unsplash.com/photo-1416339306562-f3d12fefd36f",
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Nature with beatiful "
            )
        )
    )

    private val sampleBasicList = UIField.Basic(
        listOf(
            ItemBasic(
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Notificatoin"
            ).apply {
                    optionText = "4.m"
            },
                ItemBasic(
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Notificatoin"
            ),
                ItemBasic(
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Notificatoin"
            ),
                ItemBasic(
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Notificatoin"
            ),
            ItemBasic(
                userField = UserField(
                    username = "jhondoe",
                    imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                    realName = "Jhon Doe"
                ),
                title = "Notificatoin"
            ).apply {
                    optionText = "11.m"
            },
            ItemBasic(
            userField = UserField(
                username = "jhondoe",
                imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
                realName = "Jhon Doe"
            ),
            title = "Notificatoin"
            )
        )
    )


    val sampleProfile = UIField.Profile(
        userField = UserField(
            username = "jhondoe",
            imgAvatar = "https://images.unsplash.com/profile-1441298803695-accd94000cac?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=32085a077889586df88bfbe406692202",
            realName = "Jhon Doe"
        ),
        settings = listOf(
            "Accounts",
            "Login",
            "Register",
            "Wizard",
            "Logout",
        )
    )

    val tabLayoutData = LayoutField(
        pages = listOf(
            sampleFeed,
            sampleBasicList,
            sampleProfile
        ),
        bottomNav = listOf(
            BottomNavField("home", "Feed"),
            BottomNavField("menu", "Basic"),
            BottomNavField("profile", "Profile"),
        )
    )

    val wizardData = listOf(
        listOf(
            FormField.Label(
                "Identity",
                "i",
                type = LabelType.TITLE
            ),
            FormField.TextField(
                "Input Number",
                TextFieldType.NUMBER,
                "input_number_1",
                true
            ),
            FormField.TextField(
                "Input Nominal",
                TextFieldType.NOMINAL,
                "input_nominal_1",
                true
            ),
            FormField.TextField(
                "Input Text",
                TextFieldType.TEXT,
                "input_text_1",
                true
            ),
            FormField.TextFieldOption(label = "Option", options = listOf(
                "Option 1",
                "Option 2",
                "Option 3",
                "Option 4",
            ), key = "option_1"),
        ),
        listOf(
            FormField.TextField(
                "Input Number",
                TextFieldType.NUMBER,
                "input_num_2",
                true
            ),
            FormField.TextField(
                "Input Nominal 1",
                TextFieldType.NOMINAL,
                "input_nom_2",
                true
            ),
            FormField.TextField(
                "Input Nominal 1",
                TextFieldType.NOMINAL,
                "input_nom_22",
                true
            ),
            FormField.TextField(
                "Name",
                TextFieldType.TEXT,
                "input_name",
            ),
            FormField.TextField(
                "Occupation",
                TextFieldType.TEXT,
                "input_ocupation",
            ),
            FormField.TextField(
                "Input Nominal 1",
                TextFieldType.NOMINAL,
                "input_nom_222",
            ),
            FormField.TextField(
                "Address",
                TextFieldType.TEXT,
                "input_address",
            ),

        ),
        listOf(
            FormField.TextField(
                "Input Number",
                TextFieldType.NUMBER,
                "input_num_3",
                true
            ),
            FormField.TextField(
                "Input Nominal",
                TextFieldType.NOMINAL,
                "input_nom_3",
                true
            ),
            FormField.TextField(
                "Input Nominal",
                TextFieldType.NOMINAL,
                "input_nom_3",
                true
            ),
            FormField.DatePicker(
                "Input Text",
                "input_date_3",
                true
            ),
        )
    )
}