import React, {useEffect, useRef, useState} from 'react';
import ResultsTables from '../components/ResultsTables';
import {useData} from "@/context";


const ResultsPage = () => {
    const { data } = useData();

    const [employees, setEmployees] = useState([]);
    const [jobSummary, setJobSummary] = useState([]);

    useEffect(() => {
        console.log("Data froml parent : ", data);
        // getting data from context:
        setEmployees(data.employees || []);
        setJobSummary(data.averageSalaries || []);
    }, []);

  return (
    <div>
      <h1>Results Page</h1>
         <ResultsTables employees={employees} jobSummary={jobSummary} />
    </div>
  );
};
export default ResultsPage;