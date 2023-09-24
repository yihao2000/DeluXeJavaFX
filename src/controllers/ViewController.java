package controllers;

import views.View;

public abstract class ViewController {
    private View view;

    public ViewController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
