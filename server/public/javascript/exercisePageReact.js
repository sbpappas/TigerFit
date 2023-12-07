const retrieveExerciseRoute = document.getElementById("retrieveExerciseRoute").value;
const searchExercisesRoute = document.getElementById("searchExercisesRoute").value;

const ce = React.createElement;

class Hamburger extends React.Component {
    constructor(props) {
        super(props);
        this.state = { isOpen: false };
        this.toggleMenu = this.toggleMenu.bind(this);
    }

    toggleMenu() {
        this.setState(prevState => ({
            isOpen: !prevState.isOpen
        }));
    }

    render() {
        const navbarProps = {
            className: 'hamburger-navbar',
            //className: `hamburger-navbar ${this.props.className || ''}`,
            onClick: this.toggleMenu 
        };

        const hamburgerProps = {
            className: `hamburger ${this.state.isOpen ? 'open' : ''}`
        };

        const burgerProps = index => ({
            key: index,
            className: `burger burger${index} ${this.state.isOpen ? 'open' : ''}`
        });

        return ce('div', navbarProps,
            ce('div', hamburgerProps,
                ce('div', burgerProps(1)), // First line of hamburger
                ce('div', burgerProps(2)), // Second line of hamburger
                ce('div', burgerProps(3))  // Third line of hamburger
            ),
            this.state.isOpen ? ce('div', { className: 'menu' },
                ce('a', { href: '#home' }, 'Home'),
                ce('a', { href: '#about' }, 'About'),
                ce('a', { href: '#services' }, 'Services'),
                ce('a', { href: '#contact' }, 'Contact')
            ) : null
        );
    }
}


class NavBarComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            
        };
    }

    render() {
        return ce('div', {className: "navbar"},
           ce(Hamburger, {className: "hamburger-navbar"}, null),
           ce('h1', {className: "navbar-header", onClick: e => this.goToLanding(e)}, 'TIGER FIT'),
           ce('div', {className: "navbar-login-div", onClick: e => this.goToLogin(e)}, 
            ce('h2', {className: "navbar-header"}, 'LOGIN'),
            ce('img', { src: "https://cdn4.iconfinder.com/data/icons/man-user-human-person-business-profile-avatar/100/20-1User_13-512.png", className: "login-navbar"}, null) 
           ),
           
        )
    }

    goToLogin(e) {
        console.log("Go to log in page")
        window.location.href = loginRoute;
    }

    goToLanding(e) {
        console.log("Go to landing page")
        window.location.href = landingRoute;
    }
}

class ExerciseSection extends React.Component {
    render() {
        return ce('div', {className: 'exercise name'},
<<<<<<< HEAD
            ce('h2', {className: 'text-center'}, 'Exercise: '),
=======
            ce('br'),
            ce('br'),
            ce('br'),
            ce('h2', {className: 'text-center'}, 'Exercise: '),
            ce('br'),
>>>>>>> master
            ce('h4', {className: 'text-center'}, 'Description: '),
            ce('h4', {className: 'text-center'}, 'Muscle Group: '),
            ce('h4', {className: 'text-center'}, 'Link to video: ')
        );
    }
}

class MainContainer extends React.Component {
    render() {
        return ce('div', null, 
        ce(NavBarComponent, null, null),
        ce('div', {className: 'container'},
            ce('div', {className: 'row justify-content-center'},
                ce('div', {className: 'col-md-6'},
                    ce(ExerciseSection, null, null)
                )
            )
        )
        )
    }
    
}

class Version4MainComponent extends React.Component {
    render() {
        return ce(MainContainer, null, null);
    }
}

ReactDOM.render(
    ce(Version4MainComponent, null, null),
    document.getElementById('exercise')
);