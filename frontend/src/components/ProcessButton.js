import React from 'react';

const ProcessButton = ({ onProcessClick }) => {
    return (
     <button className="button"  onClick={onProcessClick}>
             <div>
                         <button onClick={onProcessClick}>Process</button>
                     </div>
            </button>

    );
};

export default ProcessButton;