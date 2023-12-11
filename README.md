## Guyub
Guyub is Server side rendering library build dynamic ui and form multiplatform client project use with kotlin multiplatform

### How it's work 
Use what
architecture

### Component
1. Form
   | No | Component        | type                   | Parameter                            |
   |----|------------------|------------------------|--------------------------------------|
   | 1  | GLabel           | label                  | label: String, type: LabelType       |
   | 2  | GButton          | button                 | label: String, enable: Boolean       |
   | 3  | GTextField       | text field             | label: String, type: TextFieldType   |
   | 4  | GTextFieldOption | text field with option | label: String, options: List<String> |
   | 5  | GDatePicker      | date picker            | label: String                        |
   | 6  | GRadioButton     | radio button           | label: String, options: List<String> |
   | 7  | GPassword        | password               | label: String, type: PasswordType    |
   | 8  | GPhoneNumber     | phone number           | label: String                        |
   | 9  | GEmail           | email                  | label: String                        |
   | 10 | GImagePicker     | image picker           | WIP                                  |
   | 11 | GCameraPicker    | camera                 | WIP                                  |
2. Group Form
   | No | Component   | type                        | Parameter                                            |
   |----|-------------|-----------------------------|------------------------------------------------------|
   | 1  | GSingleForm | Single form page            | listData: List<FormField>, outputData: Lamda         |
   | 2  | GWizardForm | Wizard form (multiple page) | dataWizard: List<List<FormField>>, outputData: Lamda |
3. UI
   | No | Component  | type            | Parameter             |
   |----|------------|-----------------|-----------------------|
   | 1  | GBasicList | basic list      | data: UIField.Basic   |
   | 2  | GFeed      | feed            | data: UIField.Feed    |
   | 3  | GProfile   | profile         | data: UIField.Profile |
   | 4  | GTabLayout | tap layout page | data: LayoutField     |
4. Group UI
   | No | Component     | type                  | Parameter                                    |
   |----|---------------|-----------------------|----------------------------------------------|
   | 1  | GTabLayout    | Tab layout page       | data: LayoutField, onActionLayout: Lamda     |
   | 2  | GBottomAppBar | Bottom navigation bar | icons: List<BottomNavField>, selected: Lamda |

### Response Contract

### Mapper

### Validation

### Getting started
1. Android
2. iOS

