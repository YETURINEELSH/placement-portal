import React, { useEffect, useState } from "react";
import axios from "axios";

function Jobs() {

  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/jobs")
      .then(res => setJobs(res.data))
      .catch(err => console.log(err));
  }, []);

  const applyJob = (jobId) => {
    axios.post("http://localhost:8080/api/applications", {
      studentId: 1,
      jobId: jobId
    })
    .then(() => alert("Applied ✅"))
    .catch(() => alert("Already Applied ❌"));
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Jobs</h1>

      {jobs.map(job => (
        <div key={job.id} style={{ border: "1px solid gray", padding: "10px", margin: "10px" }}>
          <h3>{job.title}</h3>
          <p>{job.company}</p>
          <button onClick={() => applyJob(job.id)}>Apply</button>
        </div>
      ))}
    </div>
  );
}

export default Jobs;