
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Orders from "./Orders";
import Home from "./Home";

function Routes() {
    return (
        <BrowserRouter >
            <Switch>
            <Route path="/orders"><Orders/></Route>
            <Route path="/"><Home/></Route>
            </Switch>
        </BrowserRouter>
    )
}

export default Routes;