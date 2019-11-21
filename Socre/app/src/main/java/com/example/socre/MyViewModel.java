package com.example.socre;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

/*
 * @Author: Luke
 * @Date: 2019-11-21 12:28
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Socre
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> aTeamScore;
    private MutableLiveData<Integer> bTeamScore;
    private int aBack, bBack;
    private SavedStateHandle handle;

    public MyViewModel(SavedStateHandle handle){
        this.handle = handle;
    }

    public MutableLiveData<Integer> getaTeamScore() {
        if(!handle.contains(MainActivity.KEY_ATEAM_SCORE)){
            //当程序第一次加载进内存的时候
            handle.set(MainActivity.KEY_ATEAM_SCORE,0);
        }
//        if (aTeamScore == null) {
//            aTeamScore = new MutableLiveData<>();
//            aTeamScore.setValue(0);
//        }
        return handle.getLiveData(MainActivity.KEY_ATEAM_SCORE);
    }

    public MutableLiveData<Integer> getbTeamScore() {
        if (!handle.contains(MainActivity.KEY_BTEAM_SCORE)) {
            handle.set(MainActivity.KEY_BTEAM_SCORE, 0);
        }
        return handle.getLiveData(MainActivity.KEY_BTEAM_SCORE);
    }

    public void aTeamAdd(int p) {
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(getaTeamScore().getValue() + p);

    }

    public void bTeamAdd(int p) {
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getbTeamScore().setValue(getbTeamScore().getValue() + p);
    }

    public void reset() {
        aBack = getaTeamScore().getValue();
        bBack = getbTeamScore().getValue();
        getaTeamScore().setValue(0);
        getbTeamScore().setValue(0);
    }

    public void undo() {
        getaTeamScore().setValue(aBack);
        getbTeamScore().setValue(bBack);
    }
}
