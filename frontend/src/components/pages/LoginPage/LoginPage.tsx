import { Form, Formik } from "formik";
import { Paper, Typography, Box, Button } from "@mui/material";
import React from "react";
import MuiTextField from "../../atoms/MuiTextField/MuiTextField";
import { Link, useNavigate } from "react-router-dom";
import { useAuth } from "../../../contexts/AuthenticationContext";
import { useSnackbar } from "../../../contexts/SnackbarContext";

export default function LoginPage() {
  const navigate = useNavigate();
  const { login } = useAuth();
  const { displaySnackbarMessage } = useSnackbar();
  return (
    <div
      style={{
        display: "flex",
        height: "100vh",
        justifyContent: "center",
        alignItems: "center",
      }}
    >
      <Box sx={{ width: "90%", margin: "auto", paddingTop: 5 }}>
        <Paper elevation={8}>
          <Formik
            initialValues={{ username: "", password: "" }}
            onSubmit={(values) => {
              console.log(values);
              login(values.username, values.password)
                .then(() => navigate("/"))
                .catch((response) =>
                  displaySnackbarMessage(response.data, "error")
                );
            }}
          >
            {({ handleChange }) => (
              <Form>
                <div
                  style={{
                    textAlign: "center",
                    width: "50%",
                    margin: "auto",
                    padding: "1em",
                  }}
                >
                  <MuiTextField
                    onChange={handleChange}
                    label="Username"
                    name="username"
                  />
                  <MuiTextField
                    onChange={handleChange}
                    label="Password"
                    type="password"
                    name="password"
                  />
                  <Button
                    style={{ marginTop: 15 }}
                    type="submit"
                    variant="outlined"
                  >
                    Submit
                  </Button>
                  <Link
                    color="#63A4FF"
                    style={{ color: "#63A4FF" }}
                    to={"/signup"}
                  >
                    <Typography variant="subtitle2">
                      Don't have an account yet? Sign up
                    </Typography>
                  </Link>
                </div>
              </Form>
            )}
          </Formik>
        </Paper>
      </Box>
    </div>
  );
}
