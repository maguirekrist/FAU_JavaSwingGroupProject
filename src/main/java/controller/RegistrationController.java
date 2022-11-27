package controller;

import infastructure.IRepository;
import infastructure.ViewManager;
import model.User;
import model.UserType;
import view.RegisterView;
import view.utility.Views;

import java.awt.event.ActionEvent;

public class RegistrationController {

    private ViewManager _viewManager;
    private RegisterView _view;
    private IRepository<User> _userRepository;

    public RegistrationController(ViewManager viewManager, RegisterView view, IRepository<User> userRepository) {
        this._viewManager = viewManager;
        this._view = view;
        this._userRepository = userRepository;

        //register events
        _view.assignRegistrationAction(this::handleRegistration);
    }

    private void handleRegistration(ActionEvent e) {
        String username = _view.getUsername();
        String password = _view.getPassword();

        if(username.length() > 0 && password.length() > 0)
        {
            _userRepository.insert(new User(username, password, UserType.CUSTOMER));
            _userRepository.save();
            _viewManager.changeView(Views.Home);
        } else {
            _view.toggleFormError();
        }
    }
}
