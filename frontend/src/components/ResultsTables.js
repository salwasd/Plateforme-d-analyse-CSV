
import React from 'react';
import DataTable from 'react-data-table-component';

const ResultsTables = ({ employees, jobSummary }) => {

  const columnsTblInfos = [];
  if (employees && employees.length > 0) {
    for (let key in employees[0]) {
      columnsTblInfos.push({
        name: key,
        selector: (row) => row[key],
        sortable: true,
      });
    }
  }

  const columnsTblSummary = [];
  if (jobSummary && jobSummary.length > 0) {
    for (let key in jobSummary[0]) {
      columnsTblSummary.push({
        name: key,
        selector: (row) => row[key],
        sortable: true,
      });
    }
  }

  return (
    <div className="results-tables-container">
      <div className="results-table">
        {columnsTblInfos.length > 0 && (
          <>
            <h5>Employee Information</h5>
            <DataTable
              columns={columnsTblInfos}
              data={employees}
              pagination
              paginationPerPage={5}
              paginationRowsPerPageOptions={[5, 10, 20]}
            />
          </>
        )}
      </div>

      <div className="results-table">
        {columnsTblSummary.length > 0 && (
          <>
            <h5>Job Summary</h5>
            <DataTable
              columns={columnsTblSummary}
              data={jobSummary}
              pagination
              paginationPerPage={5}
              paginationRowsPerPageOptions={[5, 10, 20]}
            />
          </>
        )}
      </div>
    </div>
  );
};

export default ResultsTables;
