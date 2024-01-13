import React, { useState } from 'react';
import FileUploadButton from '../components/FileUploadButton';
import ProcessButton from '../components/ProcessButton';
import ResultsTables from '../components/ResultsTables';
import { useRouter } from 'next/router';

import {useData} from "@/context";

export default function Home() {

  const { data, setData } = useData();

  const router = useRouter();

  const [selectedFile, setSelectedFile] = useState(null);
  const [employees, setEmployees] = useState([]);
  const [jobSummary, setJobSummary] = useState([]);

  const handleFileUpload = (file) => {
    setSelectedFile(file);
  };

  const handleProcessClick = async () => {
    if (!selectedFile) {
      console.error('No file selected.');
      return;
    }

    const formData = new FormData();
    formData.append('file', selectedFile);

    try {
      const response = await fetch('http://localhost:8080/api/process-csv', {
        method: 'POST',
        body: formData,
      });

      if (response.ok) {
        const result = await response.json();
        console.log('API Result:', result);
        setEmployees(result.employees || []);
        setJobSummary(result.averageSalaries || {});

        // set data in context:
        setData({
          employees : result.employees,
          averageSalaries : result.averageSalaries
        });

        router.push('/results');
      } else {
        const errorMessage = await response.text();
        console.error(`Error processing CSV file: ${errorMessage}`);
      }
    } catch (error) {
      console.error('Error processing CSV file', error);
    }

  };

  return (
      <main>
        <FileUploadButton onFileUpload={handleFileUpload} />
        {selectedFile && <ProcessButton onProcessClick={handleProcessClick} />}
        {employees.length > 0 && <ResultsTables employees={employees} jobSummary={jobSummary} />}
      </main>
  );
}
