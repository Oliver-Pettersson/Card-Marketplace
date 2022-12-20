import React from 'react'
import {TextField, TextFieldProps} from "@mui/material"

export default function MuiTextField(props: TextFieldProps) {
    return (
      <TextField
      style={{ marginTop: 15 }}
      fullWidth
        {...props}
      />
    );
  }
  
