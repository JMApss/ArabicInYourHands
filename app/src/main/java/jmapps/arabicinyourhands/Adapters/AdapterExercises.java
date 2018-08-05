package jmapps.arabicinyourhands.Adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.List;

import jmapps.arabicinyourhands.ExercisesActivity;
import jmapps.arabicinyourhands.Models.ModelExercises;
import jmapps.arabicinyourhands.R;
import jmapps.arabicinyourhands.ViewHolders.HolderExercises;

public class AdapterExercises extends RecyclerView.Adapter<HolderExercises> {

    private final List<ModelExercises> mExercises;
    private final ExercisesActivity mExercisesActivity;
    private final LayoutInflater inflater;

    public AdapterExercises(List<ModelExercises> contentInExercises, ExercisesActivity exercisesActivity) {
        this.mExercises = contentInExercises;
        this.mExercisesActivity = exercisesActivity;
        this.inflater = LayoutInflater.from(mExercisesActivity);
    }

    @NonNull
    @Override
    public HolderExercises onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(
                R.layout.content_exercises_item, parent, false);
        return new HolderExercises(itemView);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(mExercises.get(position).getExercisesIdPosition());
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderExercises holder, int position) {
        final ModelExercises exerciseModel = mExercises.get(position);
        final String strTitleName = exerciseModel.getExercisesTitle();
        final String strTitleContent = exerciseModel.getExercisesTitleContent();

        final String strQuestionOne = exerciseModel.getQuestionTextOne();
        final String strAnswerTwo = exerciseModel.getAnswerTextTwo();
        final String strQuestionThree = exerciseModel.getQuestionTextThree();
        final String strAnswerFour = exerciseModel.getAnswerTextFour();
        final String strQuestionFive = exerciseModel.getQuestionTextFive();
        final String strAnswerSix = exerciseModel.getAnswerTextSix();

        final boolean questionShowing = exerciseModel.isQuestionShowing();
        final boolean answerShowing = exerciseModel.isAnswerShowing();

        holder.tbArrowQuestionOne.setOnCheckedChangeListener(null);
        holder.tbArrowAnswerTwo.setOnCheckedChangeListener(null);
        holder.tbArrowQuestionThree.setOnCheckedChangeListener(null);
        holder.tbArrowAnswerFour.setOnCheckedChangeListener(null);
        holder.tbArrowQuestionFive.setOnCheckedChangeListener(null);
        holder.tbArrowAnswerSix.setOnCheckedChangeListener(null);

        holder.tvTitleName.setText(Html.fromHtml(strTitleName));
        holder.tvTitleContent.setText(Html.fromHtml(strTitleContent));

        holder.tvQuestionNameOne.setText(Html.fromHtml(strQuestionOne));

        holder.llQuestionOne.setVisibility(questionShowing ? View.VISIBLE : View.INVISIBLE);
        holder.llQuestionTwo.setVisibility(answerShowing ? View.VISIBLE : View.INVISIBLE);
        holder.llQuestionThree.setVisibility(answerShowing ? View.VISIBLE : View.INVISIBLE);
        holder.llQuestionFour.setVisibility(answerShowing ? View.VISIBLE : View.INVISIBLE);
        holder.llQuestionFive.setVisibility(answerShowing ? View.VISIBLE : View.INVISIBLE);
        holder.llQuestionSix.setVisibility(answerShowing ? View.VISIBLE : View.INVISIBLE);

        holder.tbArrowQuestionOne.setChecked(questionShowing);
        holder.tbArrowAnswerTwo.setChecked(answerShowing);
        holder.tbArrowQuestionThree.setChecked(questionShowing);
        holder.tbArrowAnswerFour.setChecked(answerShowing);
        holder.tbArrowQuestionFive.setChecked(questionShowing);
        holder.tbArrowAnswerSix.setChecked(answerShowing);

        holder.llQuestionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mExercisesActivity.playAudioFile(exerciseModel.getQuestionAudioFileNameOne());
            }
        });

        holder.tbArrowQuestionOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                exerciseModel.setQuestionShowing(isChecked);
                holder.llQuestionOne.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
            }
        });

        if (strAnswerTwo != null) {
            holder.tvAnswerNameTwo.setText(Html.fromHtml(strAnswerTwo));
            holder.tbArrowAnswerTwo.setVisibility(View.VISIBLE);
            holder.llQuestionTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mExercisesActivity.playAudioFile(exerciseModel.getAnswerAudioFileNameTwo());
                }
            });

            holder.tbArrowAnswerTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    exerciseModel.setAnswerShowing(isChecked);
                    holder.llQuestionTwo.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
                }
            });
        } else {
            holder.llQuestionTwo.setVisibility(View.GONE);
            holder.tbArrowAnswerTwo.setVisibility(View.GONE);
        }

        if (strQuestionThree != null) {
            holder.tvQuestionNameThree.setText(Html.fromHtml(strQuestionThree));
            holder.tbArrowQuestionThree.setVisibility(View.VISIBLE);
            holder.llQuestionThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mExercisesActivity.playAudioFile(exerciseModel.getQuestionAudioFileNameThree());
                }

            });
            holder.tbArrowQuestionThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    exerciseModel.setAnswerShowing(isChecked);
                    holder.llQuestionThree.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
                }
            });
        } else {
            holder.llQuestionThree.setVisibility(View.GONE);
            holder.tbArrowQuestionThree.setVisibility(View.GONE);
        }

        if (strAnswerFour != null) {
            holder.tvAnswerNameFour.setText(Html.fromHtml(strAnswerFour));
            holder.tbArrowAnswerFour.setVisibility(View.VISIBLE);
            holder.llQuestionFour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mExercisesActivity.playAudioFile(exerciseModel.getAnswerAudioFileNameFour());
                }
            });

            holder.tbArrowAnswerFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    exerciseModel.setAnswerShowing(isChecked);
                    holder.llQuestionFour.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
                }
            });
        } else {
            holder.llQuestionFour.setVisibility(View.GONE);
            holder.tbArrowAnswerFour.setVisibility(View.GONE);
        }

        if (strQuestionFive != null) {
            holder.tvQuestionNameFive.setText(Html.fromHtml(strQuestionFive));
            holder.tbArrowQuestionFive.setVisibility(View.VISIBLE);
            holder.llQuestionFive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mExercisesActivity.playAudioFile(exerciseModel.getQuestionAudioFileNameFive());
                }
            });

            holder.tbArrowQuestionFive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    exerciseModel.setAnswerShowing(isChecked);
                    holder.llQuestionFive.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
                }
            });
        } else {
            holder.llQuestionFive.setVisibility(View.GONE);
            holder.tbArrowQuestionFive.setVisibility(View.GONE);
        }

        if (strAnswerSix != null) {
            holder.tvAnswerNameSix.setText(Html.fromHtml(strAnswerSix));
            holder.tbArrowAnswerSix.setVisibility(View.VISIBLE);
            holder.llQuestionSix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mExercisesActivity.playAudioFile(exerciseModel.getAnswerAudioFileNameSix());
                }
            });

            holder.tbArrowAnswerSix.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    exerciseModel.setAnswerShowing(isChecked);
                    holder.llQuestionSix.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
                }
            });
        } else {
            holder.llQuestionSix.setVisibility(View.GONE);
            holder.tbArrowAnswerSix.setVisibility(View.GONE);
        }

        holder.llQuestionOne.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                copyText(view.getContext(), strTitleContent, strQuestionOne);
                return false;
            }
        });

        holder.llQuestionTwo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                copyText(view.getContext(), strTitleContent, strAnswerTwo);
                return false;
            }
        });

        holder.llQuestionThree.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                copyText(view.getContext(), strTitleContent, strQuestionThree);
                return false;
            }
        });
        holder.llQuestionFour.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                copyText(view.getContext(), strTitleContent, strAnswerFour);
                return false;
            }
        });
        holder.llQuestionFive.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                copyText(view.getContext(), strTitleContent, strQuestionFive);
                return false;
            }
        });
        holder.llQuestionSix.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                copyText(view.getContext(), strTitleContent, strAnswerSix);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mExercises.size();
    }

    private void copyText(Context context, String title, String text) {
        // Кнопка КОПИРОВАТЬ
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipTwo = ClipData.newPlainText("", Html.fromHtml(title) + "\n\n" + text);

        if (clipboard != null) {
            clipboard.setPrimaryClip(clipTwo);
        }

        Toast.makeText(context, "Скопировано в буфер", Toast.LENGTH_SHORT).show();
    }
}
