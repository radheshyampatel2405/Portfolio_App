package com.example.portfolioapp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfolioapp.Protfoliodata
import com.example.portfolioapp.R
import com.example.portfolioapp.projecteList


@Composable
fun Portfolio (){

    val isopen = remember{
        mutableStateOf(false)
    }


    Surface(
        shadowElevation =  8.dp ,
            color = MaterialTheme.colorScheme.background ,
            border = BorderStroke( width=2.dp, color = Color.Black) ,
            shape = RoundedCornerShape(12.dp) ,
            contentColor = contentColorFor(backgroundColor = Color.Red) ,
            tonalElevation =120.dp ,
            modifier = Modifier
                    .height(420.dp)
                    .padding(12.dp))
    {
// This column contain  all the information which has image, name,Instagram,git
       Column (horizontalAlignment = Alignment.CenterHorizontally) {
           Spacer(modifier = Modifier.size(15.dp))

           Image(painter = painterResource(id = R.drawable.person) ,
                 contentDescription = null ,
                 modifier = Modifier.size(60.dp) ,
                 alignment = Alignment.CenterStart)

           Divider()

           Text(text = "Radheshyam Patel " ,
                color = Color.Red ,
                fontSize = 20.sp ,
                fontWeight = FontWeight.Bold)
           Text(text = "Android Compose Developer")
           
           Divider()
           Spacer(modifier = Modifier.size(13.dp))

// This row contain Instagram information
           Row (horizontalArrangement =  Arrangement.Center){

               Icon(painter = painterResource(id = R.drawable.instagram) ,
                    contentDescription = "Instagram" ,
                    modifier = Modifier.size(12.dp))
               Text(text = "/ radheshyampatelinst ")
           }

           Spacer(modifier = Modifier.size(13.dp))

// This row contain Git hub information
           Row (modifier = Modifier,Arrangement.Center){

               Icon(painter = painterResource(id = R.drawable.github) ,
                    contentDescription = "Git" ,
                    modifier = Modifier.size(12.dp))
               Text(text = "/ radheshyampatelgit ")
           }
           
           Spacer(modifier = Modifier.size(20.dp))

//  Button will the projects which we have created
           OutlinedButton(onClick = { isopen.value =! isopen.value })
//     This above statement show that isopen is true than convert into false and false to true.
           {
               Text(text = "Projects")
           }

// This lazy column is use to show project data when we click on button
           if (isopen.value) // if(isopen.value =true)
           {
               LazyColumn {

                   items(projecteList()) {

                       ProjectItems(it)
                   }
               }
           }
       }
    }
}


// This fun is taking data form the projectList and display it in a proper order manner
@Composable
fun ProjectItems (protfoliodata : Protfoliodata){

    Row (modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){

        Image(painter = painterResource(id = R.drawable.task) , contentDescription = null ,
              modifier = Modifier
                      .size(60.dp)
                      .clip(CircleShape))


    Column (modifier = Modifier.padding(horizontal = 8.dp)){
        Text(text = protfoliodata.name , style = MaterialTheme.typography.headlineSmall)
        Text(text = protfoliodata.description , style = MaterialTheme.typography.titleSmall)
    }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview()
{
   Portfolio()
}