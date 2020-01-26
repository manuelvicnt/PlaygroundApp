package com.manuelvicnt.playgroundapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manuelvicnt.playgroundapp.LogApplication
import com.manuelvicnt.playgroundapp.R
import com.manuelvicnt.playgroundapp.data.Log
import com.manuelvicnt.playgroundapp.data.LoggerLocalDataSource
import com.manuelvicnt.playgroundapp.util.DateFormatter


class LogsActivity : AppCompatActivity() {

    private lateinit var logger: LoggerLocalDataSource
    private lateinit var dateFormatter: DateFormatter

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        populateFields()
        setupViews()
    }

    private fun populateFields() {
        logger = (applicationContext as LogApplication).serviceLocator.loggerLocalDataSource
        dateFormatter = (applicationContext as LogApplication).serviceLocator.dateFormatter
    }

    private fun setupViews() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Your logs"
        }

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@LogsActivity)
        }

        logger.getAllLogs { logs ->
            recyclerView.adapter = LogsViewAdapter(logs, dateFormatter)
        }
    }
}

private class LogsViewAdapter(
    private val logsDataSet: List<Log>,
    private val daterFormatter: DateFormatter
) : RecyclerView.Adapter<LogsViewAdapter.LogsViewHolder>() {

    class LogsViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        return LogsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.text_row_item, parent, false) as TextView
        )
    }

    override fun getItemCount(): Int {
        return logsDataSet.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        val log = logsDataSet[position]
        holder.textView.text = "${log.msg}\n\t${daterFormatter.formatDate(log.timestamp)}"
    }
}
