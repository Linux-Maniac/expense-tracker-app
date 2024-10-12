import DatePicker from "react-datepicker";

import 'react-datepicker/dist/react-datepicker.css';
import { useEffect, useState } from "react";
import AppNav from "./AppNav";
import { Button, Container, Form, FormGroup } from "reactstrap";
import { Link } from "react-router-dom";

const initState = {
    isLoading: true,
    expenses: [],
    categories: []
};

function Expenses() {
    const [data, setData] = useState(initState);

    function handleChange() {

    }

    function handleSubmit() {

    }

    function handleDateChange() {

    }

    useEffect(() => {
        fetch("/api/category/all")
            .then(resp => {
                return resp.json()
            })
            .then(jsonResp => {
                const newState = {
                    isLoading: false,
                    expenses: [],
                    categories: jsonResp
                };
                setData(newState)
            })
    }, []);

    if (data.isLoading) {
        return (
            <div>Loading...</div>
        )
    }

    console.log("Categories:");
    console.log(data.categories);

    return (
        <>
            <AppNav />
            <Container>
                <Form onSubmit={handleSubmit}>
                    <FormGroup>
                        <label htmlFor="title">Title</label>{' '}
                        <input type="text" name="title" id="title" onChange={handleChange} autoComplete="name" />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="category">Category</label>{' '}
                        <select>
                            {
                                data.categories.map(category => {
                                    return (
                                        <option id={category.id}>{category.name}</option>
                                    );
                                })
                            }
                        </select>{' '}
                        <input type="text" name="category" id="category" onChange={handleChange} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="expenseDate">Expense Date</label>{' '}
                        <DatePicker selected={data.date} onChange={handleDateChange} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="location">Location</label>{' '}
                        <input type="text" name="location" id="location" onChange={handleChange} />
                    </FormGroup>
                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button>{' '}
                        <Button color="secondary" tag={Link} to="/categories">Cancel</Button>
                    </FormGroup>
                </Form>
            </Container>
        </>
    );
}

export default Expenses;