package com.example.sahithi.objectparsing

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    var url1="http://www.mocky.io/v2/5c5d05d23200004e112205c4"
    var url2="http://www.mocky.io/v2/5c5d100f320000ed102205e9"
    var url3="http://www.mocky.io/v2/5c5d28043200002f1122066a"
    var button1: Button?=null
    var button2: Button?=null
    var button3:Button?=null
    var button4:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button_next)
        var request=Volley.newRequestQueue(this@MainActivity)
        button1!!.setOnClickListener {

            var objectrequest1=JsonObjectRequest(Request.Method.GET,url1,null, Response.Listener<JSONObject>
            {
                response: JSONObject? ->
                //Log.d("response",response.toString())
                request.stop()
                var gson=Gson()
                var model=gson.fromJson(response.toString(),Model::class.java)
                var sb1=StringBuilder()
                sb1.append("Glossary name:").append(model.glossary.title)
                    .append("Glossary division:").append(model.glossary.glossDiv.title).append(";").append(model.glossary.glossDiv.glossList.glossEntry.abbrev).append("     ")
                    .append(model.glossary.glossDiv.glossList.glossEntry.acronym).append("     ")
                    .append(model.glossary.glossDiv.glossList.glossEntry.id).append("     ")
                    .append(model.glossary.glossDiv.glossList.glossEntry.sortAs).append("     ")
                    .append(model.glossary.glossDiv.glossList.glossEntry.glossTerm).append("     ")
                    .append(model.glossary.glossDiv.glossList.glossEntry.glossSee).append("     ")
                    .append(model.glossary.glossDiv.glossList.glossEntry.glossDef.para).append("     ")
                    .append(model.glossary.glossDiv.glossList.glossEntry.glossDef.glossSeeAlso.get(0)).append("     ")
                    .append(model.glossary.glossDiv.glossList.glossEntry.glossDef.glossSeeAlso.get(1))
               Toast.makeText(this@MainActivity,sb1.toString(),Toast.LENGTH_LONG).show()
                button1!!.setText(sb1.toString())
            },Response.ErrorListener {
                error: VolleyError? ->
                Toast.makeText(this@MainActivity,error.toString(),Toast.LENGTH_LONG).show()
                request.stop()
            })
            request.add(objectrequest1)
        }
        button2!!.setOnClickListener {
           var request2=Volley.newRequestQueue(this@MainActivity)
            var objectrequest2=JsonObjectRequest(Request.Method.GET,url2,null,Response.Listener<JSONObject> {
                response: JSONObject? ->
               request2.stop()
                var gson=Gson()
                var model2=gson.fromJson(response.toString(),Model2::class.java)
                var sb2=StringBuilder()
                sb2.append(model2.menu.id).append("  ").append(model2.menu.value).append("  ")
                var list=model2.menu.popup.menuitem
                for(i in 0 ..list.size-1)
                {
                   sb2.append(list.get(i).onclick).append(",").append(sb2.append(list.get(i).value))
                }
                button2!!.setText(sb2.toString())

            },Response.ErrorListener {
                error: VolleyError? ->
                request2.stop()
            })
            request2.add(objectrequest2)
        }
        button3!!.setOnClickListener {
            var request3=Volley.newRequestQueue(this@MainActivity)
            var jsonobject1=JSONObject()
            jsonobject1.put("greetings","welcome to the android volley tutorial using post method")
            var putStringRequest=JsonObjectRequest(Request.Method.POST,url3,jsonobject1,Response.Listener {
                response ->
                request3.stop()
              Log.d("jfdjjgd",response.toString())
            },Response.ErrorListener {

                error: VolleyError? ->
                request3.stop()
            })
            request3.add(putStringRequest)
            request3.start()
        }
        button4!!.setOnClickListener {
            var intent= Intent(this@MainActivity,Retrofits::class.java)
            startActivity(intent)
        }
    }
}
