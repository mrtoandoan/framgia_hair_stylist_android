package com.framgia.fsalon.screen.scheduler;

/**
 * Exposes the data to be used in the Scheduler screen.
 */
public class SchedulerViewModel implements SchedulerContract.ViewModel {
    private SchedulerContract.Presenter mPresenter;

    public SchedulerViewModel() {
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(SchedulerContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
