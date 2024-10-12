import { useEffect, useState } from "react";
import AppNav from "./AppNav";

function Category() {
    const [data, setData] = useState("Loading...");

    useEffect(() => {
        fetch("/api/category/all")
            .then(resp => {
                return resp.json()
            })
            .then(jsonResp => {
                setData(jsonResp)
            })
    }, []);

    if (data === "Loading...") {
        return (
            <div>Loading...</div>
        )
    } else {
        return (
            <div>
                <AppNav />
                <h2>Categories</h2>
                {
                    data.map(category => {
                        return <div id={category.id} key={category.id}>{category.name}</div>
                    })
                }
            </div>
        )
    }
}

export default Category;