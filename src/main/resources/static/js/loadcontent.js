
     function loadContent(page) {

            console.log("loadContent.....");


            // Clear existing content
            $('#main-content').empty();

            // Load content based on the clicked button
            switch (page) {
                case 'welcome':
                    $('#main-content').load('/welcome');
                    break;
                case 'signin':
                    $('#main-content').load('/signin');
                    break;
                case 'signup':
                    $('#main-content').load('/register');
                    break;
                case 'healthinfo':
                    $('#main-content').load('/healthinfo');
                    break;
                default:
                    // Default to the welcome page
                    $('#main-content').load('/welcome');
                    break;
            }
        }