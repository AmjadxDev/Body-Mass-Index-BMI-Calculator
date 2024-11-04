# Body-Mass-Index-BMI-Calculator

    Steps:
    1. Create simple design in xml
    2. set viewBinding
    3. create calulate BMI method
    4. write BMI formula -> val bmi = weight / (height / 100).pow(2)
    5. set output on result textview
    6. call calculateBMI method inside setOnclickListener

    this is the caluclator method
        private fun calculateBMI() {
        val height = viewBinding.edtHeight.text.toString().toFloatOrNull()
        val weight = viewBinding.edtWeight.text.toString().toFloatOrNull()

        if (weight != null && height != null) {
            val bmi = weight / (height / 100).pow(2)
            val bmiResult = String.format("%.2f", bmi)

            val bmiCategory = when {
                bmi < 18.5 -> "Underweight"
                bmi < 25 -> "Normal"
                bmi < 30 -> "Overweight"
                else -> "Obese"
            }
            viewBinding.tvResult.text = "BMI : $bmiResult\nCategory : $bmiCategory"
        }else{
            viewBinding.tvResult.text = "Invalid Input"
        }
    }


# **************** Complete Application ******************
