import React, { useState } from 'react';

const FileUploadButton = ({ onFileUpload }) => {
    const handleFileChange = (e) => {
        const file = e.target.files[0];
        onFileUpload(file);
    };

    return (

        <div >

            <input type="file" className="upload-button" accept=".csv" onChange={handleFileChange} />

        </div>
    );
};

export default FileUploadButton;