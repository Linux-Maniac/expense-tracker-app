import { Nav, Navbar, NavItem, NavbarBrand, NavLink } from "reactstrap";

function AppNav() {
    return (
        <div>
            <Navbar color="light" light expand="md">
                <NavbarBrand href="/">Expense Tracker System</NavbarBrand>
                <Nav className="me-auto" navbar>
                    <NavItem>
                        <NavLink href="/home/">Home</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/categories/">Categories</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink href="/expenses/">Expenses</NavLink>
                    </NavItem>
                </Nav>
            </Navbar>
        </div >
    );
}

export default AppNav;