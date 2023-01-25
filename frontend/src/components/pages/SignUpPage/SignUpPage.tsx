import { Form, Formik } from "formik";
import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { Box, Paper, Button, Typography } from "@mui/material";
import * as Yup from "yup";
import AuthenticationService from "../../../services/AuthenticationService";
import MuiTextField from "../../atoms/MuiTextField/MuiTextField";
import { useAuth } from "../../../contexts/AuthenticationContext";
import { useSnackbar } from "../../../contexts/SnackbarContext";

export default function SignUpPage() {
  const navigate = useNavigate();
  const { login } = useAuth();
  const { displaySnackbarMessage } = useSnackbar();
  const validationSchema = Yup.object().shape({
    username: Yup.string()
      .required("This field can't be empty")
      .max(255, "can't be longer than 255 characters"),
    password: Yup.string().required("This field can't be empty"),
    repeatPassword: Yup.string()
      .required("This field can't be empty")
      .oneOf([Yup.ref("password"), null], "Passwords must match"),
  });

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
        <Paper>
          <Formik
            validationSchema={validationSchema}
            initialValues={{ username: "", password: "", repeatPassword: "" }}
            onSubmit={(value) => {
              console.log(value);
              AuthenticationService().signup(value).then(() => login(value.username, value.password)
              .then(() => navigate("/"))
              ).catch(({response}) =>
              displaySnackbarMessage(response.data, "error")
            );
            }}
          >
            {({ handleChange, errors }) => (
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
                    error={errors.username !== undefined}
                    helperText={errors.username}
                    label="Username"
                    name="username"
                    onChange={handleChange}
                  />
                  <MuiTextField
                    error={errors.password !== undefined}
                    helperText={errors.password}
                    label="Password"
                    name="password"
                    type="password"
                    onChange={handleChange}
                  />
                  <MuiTextField
                    error={errors.repeatPassword !== undefined}
                    helperText={errors.repeatPassword}
                    label="Repeat Password"
                    name="repeatPassword"
                    type="password"
                    onChange={handleChange}
                  />
                  <Button
                    style={{ marginTop: 15 }}
                    variant="outlined"
                    type="submit"
                  >
                    Submit
                  </Button>
                  <Link
                    color="#63A4FF"
                    style={{ color: "#63A4FF" }}
                    to={"/login"}
                  >
                    <Typography variant="subtitle2">
                      Already have an account? Log in
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
