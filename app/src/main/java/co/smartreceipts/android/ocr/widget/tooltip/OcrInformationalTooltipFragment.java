package co.smartreceipts.android.ocr.widget.tooltip;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import co.smartreceipts.android.ocr.purchases.OcrPurchaseTracker;
import co.smartreceipts.android.widget.tooltip.Tooltip;
import dagger.android.support.AndroidSupportInjection;

public class OcrInformationalTooltipFragment extends Fragment {

    @Inject
    OcrInformationalTooltipInteractor interactor;

    @Inject
    OcrPurchaseTracker ocrPurchaseTracker;

    private OcrInformationalTooltipPresenter presenter;


    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new Tooltip(getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new OcrInformationalTooltipPresenter(interactor, (Tooltip) view, ocrPurchaseTracker);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        presenter.onPause();
        super.onPause();
    }
}
